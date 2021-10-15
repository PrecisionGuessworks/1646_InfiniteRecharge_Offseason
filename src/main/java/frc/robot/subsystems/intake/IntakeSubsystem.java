/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  
  private static IntakeSubsystem instance;
  private VictorSPX rollerMotor;
  private VictorSPX armMotor;
  private Encoder armEncoder; 
  
  /**
   * Creates a new IntakeSubsystem.
   */
  private IntakeSubsystem() {
    rollerMotor = new VictorSPX(RobotMap.INTAKE_ROLLER_MOTOR_ID);
    armMotor = new VictorSPX(RobotMap.INTAKE_ARM_MOTOR_ID);
    armEncoder = new Encoder(RobotMap.INTAKE_ARM_ENCODE_CHANNEL_A, RobotMap.INTAKE_ARM_ENCODE_CHANNEL_B);
  }

  public static IntakeSubsystem getInstance() {
    if (instance == null){
      instance = new IntakeSubsystem();
    }
    return instance;
  }

  public void setRollerPower(double power){
    rollerMotor.set(ControlMode.PercentOutput, power);
  }
  //TODO: Finish the extend and retract functions (based on how it's done)
  public void extend(){
    if (getArmPosition() > IntakeConstants.lowerArmBound){
      setArmPower(IntakeConstants.armPower);
    }else{
      setArmPower(0.0);
    }
  }

  public void retract(){
    if (getArmPosition() < IntakeConstants.upperArmBound){
      setArmPower(-1 * IntakeConstants.armPower);
    }else{
      setArmPower(0.0);
    }
  }

  public void setArmPower(double power){
    armMotor.set(ControlMode.PercentOutput, power);
  }

  public double getArmPosition(){
    return armEncoder.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
