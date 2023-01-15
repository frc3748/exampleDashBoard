package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Drive extends SubsystemBase{

    private CANSparkMax frontRight;
    private CANSparkMax frontLeft;
    private CANSparkMax backRight;
    private CANSparkMax backLeft;

    public Drive()
    {
        frontRight = new CANSparkMax(Constants.CANSparkIDs.frontRightID, MotorType.kBrushless); 
        frontLeft = new CANSparkMax(Constants.CANSparkIDs.frontLeftID, MotorType.kBrushless); 
        backRight = new CANSparkMax(Constants.CANSparkIDs.backRightID, MotorType.kBrushless); 
        backLeft = new CANSparkMax(Constants.CANSparkIDs.backLeftID, MotorType.kBrushless); 
    }

    public void putSmartDashboard() 
    {
        CANSparkMax lMotors[] = {frontLeft, backLeft};
        CANSparkMax rMotors[] = {frontRight, backRight};

        MotorGroup lMotorGroup = new MotorGroup(lMotors);
        MotorGroup rMotorGroup = new MotorGroup(rMotors);

        SmartDashboard.putNumber("1", lMotorGroup.getMotorSpeed());
        SmartDashboard.putNumber("2", rMotorGroup.getMotorSpeed());
    }

}

