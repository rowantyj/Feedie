<?php

//load and connect to MySQL database stuff
require("config.inc.php");

if (!empty($_POST)) {
	//initial query
	$query = "INSERT INTO topic ( topicid, title, description, ,category, label, isVerified ) 
    VALUES ( :topicid, :title, :message, :description, :category, :label, :isVerified") ";

    //Update query
    $query_params = array(
        ':topicid' => $_POST['topicid'],
        ':title' => $_POST['title'],
		':description' => $_POST['description'],
        ':category => $_POST[category]',
        ':label => $_POST[label]',
        ':isVerified => $_POST[isVerified]'
    );
  
	//execute query
    try {
        $stmt   = $db->prepare($query);
        $result = $stmt->execute($query_params);
    }
    catch (PDOException $ex) {
        // For testing, you could use a die and message. 
        //die("Failed to run query: " . $ex->getMessage());
        
        //or just use this use this one:
        $response["success"] = 0;
        $response["message"] = "Database Error. Couldn't add post!";
        die(json_encode($response));
    }

    $response["success"] = 1;
    $response["message"] = "Comment Successfully Added!";
    echo json_encode($response);
   
} else {
?>
		<h1>Add Topic</h1> 
		<form action="addtopic.php" method="post"> 
		    Topid_id:<br /> 
		    <input type="text" name="topicid" placeholder="topicid" /> 
		    <br /><br /> 
		    Title:<br /> 
		    <input type="text" name="title" placeholder="post title" /> 
		    <br /><br />
			Description:<br /> 
		    <input type="text" name="description" placeholder="Description" /> 
		    <br /><br />
            Category:<input type="text" name="category" placeholder="Category" /> 
            <br /><br />
            Label:<input type="text" name="label" placeholder="Label" /> 
            <br /><br />
            isVerified:<input type="text" name="isVerified" placeholder="IsVerified" /> 
            <br /><br />


		    <input type="submit" value="Add Comment" /> 
		</form> 
	<?php
}

?> 