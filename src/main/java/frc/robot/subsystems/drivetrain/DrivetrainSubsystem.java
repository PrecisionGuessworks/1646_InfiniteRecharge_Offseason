/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.RobotMap;
import frc.robot.lib.TalonFXFactory;
import frc.robot.Constants.DrivetrainConstants;

public class DrivetrainSubsystem extends SubsystemBase {
  
  private static DrivetrainSubsystem instance;
  private TalonFX motorFL, motorFR, motorBL, motorBR;

  public static final double kDefaultQuickStopThreshold = 0.2;
  public static final double kDefaultQuickStopAlpha = 0.1;

  private double m_quickStopThreshold = kDefaultQuickStopThreshold;
  private double m_quickStopAlpha = kDefaultQuickStopAlpha;
  private double m_quickStopAccumulator;

  private DrivetrainSubsystem() {
    motorFL = TalonFXFactory.createPIDTalonFX(RobotMap.DRIVETRAIN_FL_MOTOR_ID, true, DrivetrainConstants.LEFT_PID_P, DrivetrainConstants.LEFT_PID_I, DrivetrainConstants.LEFT_PID_D, DrivetrainConstants.LEFT_PID_F);
    motorFR = TalonFXFactory.createPIDTalonFX(RobotMap.DRIVETRAIN_FR_MOTOR_ID, false, DrivetrainConstants.RIGHT_PID_P, DrivetrainConstants.RIGHT_PID_I, DrivetrainConstants.RIGHT_PID_D, DrivetrainConstants.RIGHT_PID_F);
    motorBL = TalonFXFactory.createFollowerTalonFX(RobotMap.DRIVETRAIN_BL_MOTOR_ID, motorFL);
    motorBR = TalonFXFactory.createFollowerTalonFX(RobotMap.DRIVETRAIN_BR_MOTOR_ID, motorFR);
  }

  public static DrivetrainSubsystem getInstance(){
    if (instance == null){
      instance = new DrivetrainSubsystem();
    }
    return instance;
  }

  public void setPower(double leftPower, double rightPower){
    motorFL.set(ControlMode.PercentOutput, leftPower);
    motorFR.set(ControlMode.PercentOutput, rightPower);
  }

  public void setSpeed(double leftSpeed, double rightSpeed){
    motorFL.set(ControlMode.Velocity, leftSpeed);
    motorFR.set(ControlMode.Velocity, rightSpeed);
  }


  public void arcadeDrive(double throttle, double rotation){
    double leftPower = throttle - rotation;
    double rightPower = throttle + rotation;
    setPower(leftPower, rightPower);
  }

  public void setDrivePowerWithCurvature(double xSpeed, double zRotation, boolean isQuickTurn){
    xSpeed = MathUtil.clamp(xSpeed, -1.0, 1.0);
    //xSpeed = applyDeadband(xSpeed, m_deadband);

    zRotation = MathUtil.clamp(zRotation, -1.0, 1.0);
    //zRotation = applyDeadband(zRotation, m_deadband);

    double angularPower;
    boolean overPower;

    if (isQuickTurn) {
      if (Math.abs(xSpeed) < m_quickStopThreshold) {
        m_quickStopAccumulator = (1 - m_quickStopAlpha) * m_quickStopAccumulator
            + m_quickStopAlpha * MathUtil.clamp(zRotation, -1.0, 1.0) * 2;
      }
      overPower = true;
      angularPower = zRotation;
    } else {
      overPower = false;
      angularPower = Math.abs(xSpeed) * zRotation - m_quickStopAccumulator;

      if (m_quickStopAccumulator > 1) {
        m_quickStopAccumulator -= 1;
      } else if (m_quickStopAccumulator < -1) {
        m_quickStopAccumulator += 1;
      } else {
        m_quickStopAccumulator = 0.0;
      }
    }

    double leftMotorOutput;
    double rightMotorOutput;

    leftMotorOutput = xSpeed + angularPower;
    rightMotorOutput = xSpeed - angularPower;
    // If rotation is overpowered, reduce both outputs to within acceptable range
    if (overPower) {
      if (leftMotorOutput > 1.0) {
        rightMotorOutput -= leftMotorOutput - 1.0;
        leftMotorOutput = 1.0;
      } else if (rightMotorOutput > 1.0) {
        leftMotorOutput -= rightMotorOutput - 1.0;
        rightMotorOutput = 1.0;
      } else if (leftMotorOutput < -1.0) {
        rightMotorOutput -= leftMotorOutput + 1.0;
        leftMotorOutput = -1.0;
      } else if (rightMotorOutput < -1.0) {
        leftMotorOutput -= rightMotorOutput + 1.0;
        rightMotorOutput = -1.0;
      }
    }

    // Normalize the wheel speeds
    double maxMagnitude = Math.max(Math.abs(leftMotorOutput), Math.abs(rightMotorOutput));
    if (maxMagnitude > 1.0) {
      leftMotorOutput /= maxMagnitude;
      rightMotorOutput /= maxMagnitude;
    }

    setPower(leftMotorOutput, rightMotorOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
