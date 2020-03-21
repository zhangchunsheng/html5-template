<?php
if(isset($_POST) && !empty($_POST)){
	$first_name = (isset($_POST['first_name']))?$_POST['first_name']:'';
	$last_name = (isset($_POST['last_name']))?$_POST['last_name']:'';
	$email = (isset($_POST['email']))?$_POST['email']:'';
	$subject = (isset($_POST['subject']))?$_POST['subject']:'';
	$message = (isset($_POST['message']))?$_POST['message']:'';
	
	if($full_name == ''){
		$full_name =  $first_name.' '.$last_name;
	}
	
	$sendMessage = $mailSubject = '';
	$mailSubject = 'Mail de contacto desde la web';
		$sendMessage = "<p>Hola,</p><p>".$full_name." envió un mensaje con:"."</p><p><b>Email:</b> ".$email."</p><p><b>Asunto:</b> ".$subject."</p><p><b>Mensaje:</b> ".$message."</p>";
	
	if($sendMessage != ''){
		$fromEmail = 'consultas@merenguesestallitos.com.ar';
		$toEmail = 'consultas@merenguesestallitos.com.ar';
		
		$headers = "MIME-Version: 1.0" . "\r\n";
		$headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
		$headers .= "From: <$fromEmail>" . "\r\n";

		if(mail($toEmail , $mailSubject , $sendMessage , $headers)){
			echo 1;
		}else{
			echo 0;
		}
	}else{
		echo 0;
	}
}else{
	echo 0;
}

?>