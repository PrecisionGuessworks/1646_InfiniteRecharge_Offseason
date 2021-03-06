/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
        public static final double armPower = 0.5;

        public static final double lowerArmBound = 0.0;
        public static final double upperArmBound = 1.0;
    }


    public final class HopperConstants{
        public static final double feedInPower = 0.8;
        public static final double dejamPower = -0.4; //Must be opposite sign as feedInPower
        public static final double elevatorDejamPower = -0.25;
    }

    public final class ShooterConstants{
        public static final double LOWER_PID_P = 0.1;
        public static final double LOWER_PID_I = 0.0;
        public static final double LOWER_PID_D = 0.0;
        public static final double LOWER_PID_F = 0.5;

        public static final double UPPER_PID_P = 0.1;
        public static final double UPPER_PID_I = 0.0;
        public static final double UPPER_PID_D = 0.0;
        public static final double UPPER_PID_F = 0.5;

        public static final double MAX_VELOCITY = 100; //This is an arbitrary values that needs adjusted

        public static final double EJECT_POWER = 0.2;
        public static final double MEDIUM_SHOT_POWER = 0.65;
        public static final double LONG_SHOT_POWER = 0.9;
    }

    public final class TurretConstants{
        public static final double LOWER_POSITION_BOUND = -9842.0;
        public static final double UPPER_POSITION_BOUND = 12319.0;

        public static final double SHOOTER_RADIANS_TO_CP100MS = (22161/Math.PI);
        public static final double LIMELIGHTX_TO_RADIANS = (Math.PI / 180);

        public static final double EJECT_ANGLE_IN_RADIANS = 0.4869; //Math.atan2(9, 17);
        public static final double TOLERANCE_IN_RADIANS = 0.1745; // 5 degrees
    }

}
