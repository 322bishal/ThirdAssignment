package com.nayaapp.thirdassignment.controller;

import com.nayaapp.thirdassignment.model.UserData;

public class ControllerClass {
   public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("bishal")) && sd.getPassword().equals("322")){
            return true;

        } else {
            return false;
        }
    }


}
