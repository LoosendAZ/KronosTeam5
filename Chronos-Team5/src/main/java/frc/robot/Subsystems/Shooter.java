package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.hardware.*;

import frc.Constants;
import frc.robot.Subsystems.Indexer.IndexerStates;

public class Shooter extends SubsystemBase{
    private Shooter s_Shooter;

    private TalonFX m_Shooter;
    private TalonFX m_ShooterReverse;

    private SmartDashboard dashboard;

    public Shooter getInstance() {
        if(s_Shooter == null) {
            s_Shooter = new Shooter();
        }
        return s_Shooter;
    }
    public Shooter() {
        m_Shooter = new TalonFX(Constants.HardwarePorts.m_Shooter);
        m_ShooterReverse = new TalonFX(Constants.HardwarePorts.m_ShooterReverse);
    }

    //All values are arbitrary for now feel free to change
    public enum ShooterStates {
        ON(1.0),
        OFF(0.0),
        REVERSE(-1.0);

        private double speed;

        private ShooterStates(double state) {
            this.speed = state;
        }

        public double getSpeed() {
            return this.speed;
        }
    }

    public void setVoltage() {
        //Arbitrary value
        m_Shooter.setVoltage(IndexerStates.ON.getSpeed());
    }

    public double getVoltage() {
        return 0.0;
    }

    public void periodic() {
        dashboard.putData("Shooter motor", m_Shooter);
    }
}
