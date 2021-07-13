<?php
class Car {
    public $id = integer;
    public $license = string;
    public $driver = string;
    public $passengers = integer;

    public function __contruct($license,$driver){
        $this->license = $license;
        $this->driver = $driver;

    }
    public function PrintDataCar(){
        echo "license: $this->licence, conductor: {$this->driver->name}, document:{$this->dricer->document}";
        
    }



}
?>