/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class DrivetrainConstants{
        public static final double LEFT_PID_P = 0.1;
        public static final double LEFT_PID_I = 0.0;
        public static final double LEFT_PID_D = 0.0;
        public static final double LEFT_PID_F = 0.5;

        public static final double RIGHT_PID_P = 0.1;
        public static final double RIGHT_PID_I = 0.0;
        public static final double RIGHT_PID_D = 0.0;
        public static final double RIGHT_PID_F = 0.5;

        //Change to adjust the speed of the drivetrain
        public static final double driveDampen = 1.0;

        public static final double autoDriveTime = 1.0;

        public static final double autoDrivepower = -0.4; //Needs to be negative to go forwards, will fix later
    }
    public final class IntakeConstants{
        public static final double rollerIntakePower = 0.8;
    }


    public final class HopperConstants{
        public static final double feedInPower = 0.8;
        public static final double dejamPower = -0.4; //Must be opposite sign as feedInPower
    }

}
