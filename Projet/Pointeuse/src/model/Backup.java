package model;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * La classe Backup permet de sérialiser un objet ou de le désérialiser.
 * 
 */
public class Backup implements java.io.Serializable{
    
    private static final long serialVersionUID = 4976591707062516330L;
    
    /**
     * Fait une sauvegarde d'un objet en le sérialisant au format fichier souhaité.
     * 
     * @param savedObject
     *         Objet que l'on souhaite sérialiser
     * @param fileName
     *         Nom du fichier de sauvegarde
     */
    public static void makeBackup(Object savedObject,String fileName)
    {
        ObjectOutputStream oos = null;
        try 
        {
            final FileOutputStream fichier = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(savedObject);
            oos.flush();
        } 
        catch (final java.io.IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if (oos != null) 
                {
                    oos.flush();
                    oos.close();
                }
            } 
            catch (final IOException ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    /**
     * Lit et désérialise un fichier
     * @param fileName
     *         Nom du fichier à désérialuser
     * @return L'objet désérialisé
     */
    public static Object readBackup(String fileName)
    {
        ObjectInputStream ois = null;
        Object backupBuffer=null;//A CHANGER
        try
        {
            final FileInputStream fichier = new FileInputStream(fileName); //A CHANGER
            ois = new ObjectInputStream(fichier);
            backupBuffer=ois.readObject();
            
        }
        catch (final IOException ex) 
        {
            ex.printStackTrace();
        }
        catch(final ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try 
            {
                if (ois != null) 
                {
                    ois.close();
                }
            } 
            catch (final IOException ex) 
            {
                ex.printStackTrace();
            }
        }
        return backupBuffer;
    }
    
    /**
     * Exporte une liste d'employés au format CSV. Le filename doit être en .csv !
     * @param exportedEmployees
     *         Lste d'employés exportés
     * @param filename
     *         Fichier CSV sauvegardé
     * @throws IOException 
     */
    public static void exportEmployeeCSV(ArrayList<Employee> exportedEmployees, String filename) 
    {
    	try
    	{
	        FileWriter csvWriter = new FileWriter(filename);  
	        csvWriter.append("Name");  
	        csvWriter.append(",");  
	        csvWriter.append("Surname");  
	        csvWriter.append(",");  
	        csvWriter.append("Id");
	        csvWriter.append(",");  
	        csvWriter.append("Contact");
	        csvWriter.append(",");  
	        csvWriter.append("Standard Arrival Time");
	        csvWriter.append(",");  
	        csvWriter.append("Standard Departure Time");
	        csvWriter.append(",");  
	        csvWriter.append("Department Name");
	        csvWriter.append("\n");
	        
	        for (Employee currentEmployee : exportedEmployees) 
	        {
	            csvWriter.append(String.join(",",currentEmployee.PERGetPersonName(), 
	                    currentEmployee.PERGetPersonSurname(),
	                    Long.toString(currentEmployee.EMPGetEmpID()) ,
	                    currentEmployee.PERGetPersonContact(),
	                    currentEmployee.EMPGetStdAT().getHour().toString() ,
	                    currentEmployee.EMPGetStdDT().getHour().toString(),
	                    currentEmployee.EMPGetDepartment().getSDepName()));
	            csvWriter.append("\n");
	        }
	        
	        csvWriter.flush();  
	        csvWriter.close();
    	}
    	 catch (IOException e) {
 			JPanel popup = new JPanel();
 			popup.add(new JLabel("Pas de fichier trouvé"));
 			JOptionPane.showConfirmDialog(
 					null,
 					popup,
 	                "Erreur",
 	                JOptionPane.PLAIN_MESSAGE,
 	                JOptionPane.PLAIN_MESSAGE
 	                );
 		}
    }
    
    /**
     * Importe un fichier CSV contenant une liste d'employés.
     * @param filename
     *         Fichier importé
     * @return ArrayList contenant une liste d'employés, et une liste de départements 
     */
    public static ArrayList<Object> importEmployeeCSV(String filename)
    {
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Employee> empList = new ArrayList<Employee>();
        ArrayList<String> deptNameList = new ArrayList<String>();
        Employee empBuffer = new Employee();
        ArrayList<Object> returnList = new  ArrayList<Object>();
        
        //HashMap<Employee, Department> associationEmpDept = new HashMap<Employee, Department>();
        
        boolean firstLineDone=false;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
        
            while ((line = br.readLine()) != null) {
        
                if(firstLineDone==true)
                {
                     // sépare selon les virgules
                    String[] employeeInfo = line.split(cvsSplitBy);
                    String[] ArrivalHour = employeeInfo[4].split(":");
                    String[] DepartureHour = employeeInfo[5].split(":");
                    
                    empBuffer=new Employee(employeeInfo[0],//nom
                            employeeInfo[1], //prenom
                            Long.parseLong(employeeInfo[2]),//id
                            employeeInfo[3],//contact
                            new HourMod(ArrivalHour[0],ArrivalHour[1]), //heure arrivée
                            new HourMod(DepartureHour[0],DepartureHour[1]));
                    
                    empList.add(empBuffer);
                    deptNameList.add(employeeInfo[6]);//dept
                }
                else
                {
                    firstLineDone=true;
                }
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        returnList.add(empList);
        returnList.add(deptNameList);
        return returnList;
    }
}
