package model;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    //constructor
    public Doctor(String name, String email){
        super(name,email);
//        System.out.println("El nombre del model.Doctor asignado es: "+name);
//        this.speciality = speciality;

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void addAvailableAppointment(String date,String time){

        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nSpeciality: "+speciality +"\nAbailable: "+availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerología");
    }

    public static class AvailableAppointment{
        private  int id_availableAppointment;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //Available appointment

        public AvailableAppointment(String date, String time) {
            try{
                this.date = format.parse(date);
            }catch (ParseException e){
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId_availableAppointment() {
            return id_availableAppointment;
        }

        public void setId_availableAppointment(int id_availableAppointment) {
            this.id_availableAppointment = id_availableAppointment;
        }

        public Date getDate(String DATE) {
            return date;
        }
        public String getDate() {
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appoinments \nDate: "+date+"\nTime: "+time;
        }
    }



}
