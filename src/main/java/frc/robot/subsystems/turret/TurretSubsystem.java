// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.Constants.TurretConstants;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurretSubsystem extends SubsystemBase {

  private TalonSRX turretMotor;
  private NetworkTable limelightTable;

  private static TurretSubsystem instance;

  private TurretSubsystem() {
    turretMotor = new TalonSRX(RobotMap.TURRERT_MOTOR_ID);
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
  }

  public static TurretSubsystem getInstance() {
    if (instance == null){
      instance = new TurretSubsystem();
    }
    return instance;
  }

  public void setPositionInRadians(double positionInRadians){
    setPosition(-1238 + positionInRadians * TurretConstants.SHOOTER_RADIANS_TO_CP100MS);
  }

  public void setPosition(double positionInEncoderUnits){
    // Added to prevent the turret from turning too far and hurting itself 
    if (positionInEncoderUnits > TurretConstants.UPPER_POSITION_BOUND){
      positionInEncoderUnits = TurretConstants.UPPER_POSITION_BOUND;
    } else if (positionInEncoderUnits < TurretConstants.LOWER_POSITION_BOUND){
      positionInEncoderUnits = TurretConstants.LOWER_POSITION_BOUND;
    }

    turretMotor.set(ControlMode.Position, positionInEncoderUnits);
  }

  public void setPowerToZero(){
    // This method is was create for the intend to stop the turret motion
    // I wouldn't modify this to do any power, because it could cause safety issues
    // (for both robots and humans)
    turretMotor.set(ControlMode.PercentOutput, 0.0);
  }

  public double getTurretPositionRadians(){
    return (turretMotor.getSelectedSensorPosition() + 1238) / TurretConstants.SHOOTER_RADIANS_TO_CP100MS;
  }

  public boolean isTargetSeenByLimeLight(){
    NetworkTableEntry tv = limelightTable.getEntry("tv");
    return (tv.getDouble(0) != 0);
  }

  public double getLimeLightTargetXPosInRadians(){
    double limeLightXInRadians = getLimeLightTargetXPos() * TurretConstants.LIMELIGHTX_TO_RADIANS;
    return limeLightXInRadians;
  }

  public double getLimeLightTargetXPos(){
    NetworkTableEntry tx = limelightTable.getEntry("tx");
    return tx.getDouble(0.0);
  }



  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Limelight has target", isTargetSeenByLimeLight());
    SmartDashboard.putNumber("Limelight X", getLimeLightTargetXPos());
  }
}
