package frc.robot.Subsystems;


import com.ctre.phoenix6.*;
import com.ctre.phoenix6.hardware.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private Intake s_Intake;

    private TalonFX m_IntakeLeader;
    private TalonFX m_IntakeFollower;

    public Intake getInstance() {
        if(s_Intake == null) {
            s_Intake = new Intake();
        }
        return s_Intake;
    }
    public Intake() {
        m_IntakeLeader = new TalonFX(123);
        m_IntakeFollower = new TalonFX(456);
    }

    //All values are arbitrary for now feel free to change

    public enum IntakeStates {
        ON(),
        OFF(),
        REVERSE();

        private double speed;

        private IntakeStates() {

        }
    }

    public void periodic() {

    }
    
}
