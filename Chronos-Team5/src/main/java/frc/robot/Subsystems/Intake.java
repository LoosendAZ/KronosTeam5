package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private Intake s_Intake;
    public Intake getInstance() {
        if(s_Intake == null) {
            s_Intake = new Intake();
        }
        return s_Intake;
    }
    public Intake() {

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
