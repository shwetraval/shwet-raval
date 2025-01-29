<?php
class person 
    {
        public $p_id = ($_POST['id']);
        public $p_name;
        public $p_phone;
        public function getdata($p_id,$p_name,$p_phone)
        {
            $this->p_id=$p_id;
            $this->p_name=$p_name;
            $this->p_phone=$p_phone;
        }
        public function display()
        {
            echo " person id=$this->p_id<br>";
            echo " person name=$this->p_name<br>";
            echo " person phone=$this->p_phone<br>";
            echo"----------------------------------------<br>";
        }
    }
    class employee extends person 
        {
            public $em_id;
            public $em_salary;
            public $em_company;
            public function get_data($id,$s,$co)
            {
                $this->em_id=$id;
                $this->em_salary=$s;
                $this->em_company=$co;

            }
            public function print1()
            {
                echo " employee id =$this->em_id<br>";
                echo " employee salary =$this->em_salary<br>";
                echo " employee company =$this->em_company<br>";
                echo"-------------------------------------------<br>";
            }

        }
class programers extends employee
{
    public function languges($lang)
    {
        echo " languges khown <br>";
        foreach($lang as $l)
        {
            echo " $l <br>";
        }
    }
}
$s1=new programers();
$s1->getdata("nitesh",8238477361);
$s1->display();
$s1->get_data(7125,8000,"tata");
$s1->print1();
$a=array("python","c","c++","java");
$s1->languges($a);
?>