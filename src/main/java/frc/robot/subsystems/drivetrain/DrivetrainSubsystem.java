/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DrivetrainSubsystem extends SubsystemBase {
  
  private TalonFX motorFL, motorFR, motorBL, motorBR;

  public DrivetrainSubsystem() {
    motorFL = new TalonFX(RobotMap.DRIVETRAIN_FL_MOTOR_ID);
    motorFR = new TalonFX(RobotMap.DRIVETRAIN_FR_MOTOR_ID);
    motorBL = new TalonFX(RobotMap.DRIVETRAIN_BL_MOTOR_ID);
    motorBR = new TalonFX(RobotMap.DRIVETRAIN_BR_MOTOR_ID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
