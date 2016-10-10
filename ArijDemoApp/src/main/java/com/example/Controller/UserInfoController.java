package com.example.Controller;

import com.example.Dao.UserDao;
import com.example.model.AppUser;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Arij Hussain on 10/7/2016.
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserDao userDao;

    /**
     * create the user
     */
    @RequestMapping(value = "/createuser", method = RequestMethod.GET,
            produces = "application/json")
    public String createUser() throws FileNotFoundException {

        Gson gson = new Gson();
        AppUser user = gson.fromJson(new FileReader("C:\\Users\\Arij\\Desktop\\Work\\SampleJson\\user1.json"), AppUser.class);
        try {
            userDao.create(user);
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User created successfully!";
}

    /**
     * delete the user
     */
    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET,
            produces = "application/json")
    public String deleteUser() throws FileNotFoundException {

        Gson gson = new Gson();
        AppUser user = gson.fromJson(new FileReader("C:\\Users\\Arij\\Desktop\\Work\\SampleJson\\user3.json"), AppUser.class);
        try {
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User deleted successfully!";
    }

    /**
     * Get the name of the user identified by the id
     */
    @RequestMapping(value = "/namebyid", method = RequestMethod.GET,
            produces = "application/json")
    public String getUserNameById() throws FileNotFoundException {

        String userName;
        try {
          AppUser appUser =  userDao.getUserById(30);
          userName = appUser.getName();
        }
        catch (Exception ex) {
            return "Not found: " + ex.toString();
        }
        return "The user name is: " + userName;
    }

    /**
     * Update the info for the user identified by the id
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET,
            produces = "application/json")
    public String updateName(int id, String name, String address, String userType) {
        try {
            AppUser user = userDao.getUserById(id);
            user.setName(name);
            user.setAddress(address);
            user.setUserType(userType);
            userDao.update(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User updated successfully!";
    }

}
