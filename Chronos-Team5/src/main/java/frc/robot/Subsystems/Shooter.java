package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private Shooter s_Shooter;
    public Shooter getInstance() {
        if(s_Shooter == null) {
            s_Shooter = new Shooter();
        }
        return s_Shooter;
    }
    public Shooter() {

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

    public void periodic() {

    }
}
