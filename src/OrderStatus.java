/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author awl5472
 */
public class OrderStatus {
    private int intID;

    @Override
    public String toString() {
        return "OrderStatus{" + "intID=" + intID + ", strShortName=" + strShortName + ", strLongName=" + strLongName + '}';
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public String getStrShortName() {
        return strShortName;
    }

    public void setStrShortName(String strShortName) {
        this.strShortName = strShortName;
    }

    public String getStrLongName() {
        return strLongName;
    }

    public void setStrLongName(String strLongName) {
        this.strLongName = strLongName;
    }
    private String strShortName;
    private String strLongName;
}