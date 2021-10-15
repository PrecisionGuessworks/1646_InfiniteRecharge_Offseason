/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.lib.TalonFXFactory;

public class ShooterSubsystem extends SubsystemBase {
  
  private TalonFX lowerShooterMotor, upperShooterMotor;
  private static ShooterSubsystem instance;

  private ShooterSubsystem() {
    lowerShooterMotor = TalonFXFactory.createPIDTalonFX(RobotMap.SHOOTER_LOWER_MOTOR_ID, 1, 0, 0, 0);
    upperShooterMotor = TalonFXFactory.createPIDTalonFX(RobotMap.SHOOTER_LOWER_MOTOR_ID, true, 1, 0, 0, 0);
  }

  public static ShooterSubsystem getInstance(){
    if (instance == null){
      instance = new ShooterSubsystem();
    }
    return instance;
  }

  public void setPower(double power){
    lowerShooterMotor.set(ControlMode.PercentOutput, power);
    upperShooterMotor.set(ControlMode.PercentOutput, power);
  }

  public void setVelocity(double velocity){
    lowerShooterMotor.set(ControlMode.Velocity, velocity);
    upperShooterMotor.set(ControlMode.Velocity, velocity);
  }

  public void setVelocityWithArbitraryFeedForward(double velocity){
    lowerShooterMotor.set(ControlMode.Velocity, velocity, DemandType.ArbitraryFeedForward, velocity/Constants.ShooterConstants.MAX_VELOCITY);
    upperShooterMotor.set(ControlMode.Velocity, velocity, DemandType.ArbitraryFeedForward, velocity/Constants.ShooterConstants.MAX_VELOCITY);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
