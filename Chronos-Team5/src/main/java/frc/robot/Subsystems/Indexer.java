package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase{
    private Indexer s_Indexer;
    
    public Indexer getInstance() {
        if(s_Indexer == null) {
            s_Indexer = new Indexer();
        }
        return s_Indexer;
    }

    public Indexer() {

    }

    //All values are arbitrary for now feel free to change

    public enum IndexerStates {
        ON(),
        OFF(),
        REVERSE();

        private double speed;

        private IndexerStates() {

        }
    }

    public void periodic() {

    }
}
