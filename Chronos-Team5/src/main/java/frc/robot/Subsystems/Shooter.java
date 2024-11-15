package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.hardware.*;

public class Shooter extends SubsystemBase{
    private Shooter s_Shooter;

    private TalonFX m_Shooter;
    private TalonFX m_ShooterReverse;

    public Shooter getInstance() {
        if(s_Shooter == null) {
            s_Shooter = new Shooter();
        }
        return s_Shooter;
    }
    public Shooter() {
        m_Shooter = new TalonFX(123);
        m_ShooterReverse = new TalonFX(456);
    }

    //All values are arbitrary for now feel free to change

    public enum ShooterStates {
        ON(),
        OFF(),
        REVERSE();

        private double speed;

        private ShooterStates() {

        }
    }

    public double getVoltage() {
        return 0.0;
    }

    public void periodic() {

    }
}
