/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.hopper;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;


public class HopperSubsystem extends SubsystemBase {

  private VictorSPX feederWheelMotor;
  private VictorSPX dejamWheelMotor;

  private static HopperSubsystem instance;

  private HopperSubsystem() {
    feederWheelMotor = new VictorSPX(RobotMap.HOPPER_FEEDER_WHEEL_MOTOR_ID);
    dejamWheelMotor = new VictorSPX(RobotMap.HOPPER_DEJAM_WHEEL_MOTOR_ID);
  }

  public static HopperSubsystem getInstance(){
    if (instance == null){
        instance = new HopperSubsystem();
    }
    return instance;
  }

  public void setFeederWheelPowerTo(double power){
    feederWheelMotor.set(ControlMode.PercentOutput, power);
  }

  public void setDejamWheelPowerTo(double power){
    dejamWheelMotor.set(ControlMode.PercentOutput, power);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
