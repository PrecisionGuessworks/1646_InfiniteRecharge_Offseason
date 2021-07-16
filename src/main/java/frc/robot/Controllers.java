package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controllers {

    private static Joystick driverController;
    private static Joystick operatorController;

    public static Joystick getDriverController(){
        if (driverController == null){
            driverController = new Joystick(RobotMap.DRIVER_CONTROLLER_ID);
        }
        return driverController;
    }
    
    public static Joystick getOperatorController(){
        if (operatorController == null){
            operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER_ID);
        }
        return operatorController;
    }
    
}
