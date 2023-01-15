package frc.robot.subsystems;

import javax.management.relation.RelationServiceNotRegisteredException;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import frc.robot.Constants;

public class MotorGroup {
    CANSparkMax[] motors;
    RelativeEncoder[] encoders;

    public MotorGroup(CANSparkMax [] motors)
    {
        for(int i = 0; i < this.motors.length; i++)
        {
            encoders[i] = this.motors[i].getEncoder();
        }

        for(RelativeEncoder encoder: this.encoders)
        {
            encoder.setPositionConversionFactor(Constants.motorgroup.PositionConversionFactor);
            encoder.setPositionConversionFactor(Constants.motorgroup.VelocityConversionFactor);
        }
    }

    public double getMotorSpeed()
    {
        double avgMotorSpeed = 0;
        for(RelativeEncoder encoder : this.encoders)
        {
            avgMotorSpeed += encoder.getVelocity();
        }
        avgMotorSpeed = avgMotorSpeed/this.encoders.length;
        return avgMotorSpeed; 
    }
}
