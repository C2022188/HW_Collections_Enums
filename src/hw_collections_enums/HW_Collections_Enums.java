/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw_collections_enums;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author caroo
 */
public class HW_Collections_Enums { 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        List<teamMembers> groupTeam = new ArrayList<>(); //to create a list to store information from teamMembers class
       
        try(
                BufferedReader teamFile = new BufferedReader(new FileReader("MOCK_DATA.csv"))){ //read the file .csv with ID, names, lastnames, emails
        
        String team;
        
        while ((team = teamFile.readLine()) != null) {
            
            String[] team1 = team.split(",");
            if(team1.length >= 4){
                //take the data from the file
                int ID = Integer.parseInt(team1[0]);
                String name = team1[1];
                String lastName = team1[2];
                String email = team1[3];
                
                teamMembers member = new teamMembers (ID, name, lastName, email); //to create an object from the class teamMembers and add to the list
                groupTeam.add(member);
            }
           
    }
    
}
        Collections.shuffle(groupTeam); //to randomize the order from the file 
        
        int nummembers = 5; //numbers of members per group
        int teamGroups = 20; //numbers of groups
        
        for (int i = 0; i <teamGroups; i++){ //to create groups with numbers
            System.out.println("Group " + (i + 1) + ":");
            
            for (int j = 0; j < nummembers; j++){
                //take a member from the file to add to groups
                teamMembers member = groupTeam.get(i * nummembers + j);
                System.out.println("ID: " + member.getID() + ", Name: " + member.getName() + " " + member.getLastName());
            }
            System.out.println();
            }
        
        }
        
}
