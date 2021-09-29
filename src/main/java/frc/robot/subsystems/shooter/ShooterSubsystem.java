/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.lib.TalonFXFactory;

public class ShooterSubsystem extends SubsystemBase {
  
  TalonFX lowerShooterMotor, upperShooterMotor;

  public ShooterSubsystem() {
    lowerShooterMotor = TalonFXFactory.createPIDTalonFX(RobotMap.SHOOTER_LOWER_MOTOR_ID, 1, 0, 0, 0);
    upperShooterMotor = TalonFXFactory.createPIDTalonFX(RobotMap.SHOOTER_LOWER_MOTOR_ID, true, 1, 0, 0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
