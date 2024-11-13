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

    //https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2025-beta-latest.json
    //https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2024-latest.json

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
