<?php
    require_once('Car.php');
    require_once('Account.php');
    $car = new Car("AWS123", new Account("AldoVs","credencial"));
    $car ->PrintDataCar();

?>