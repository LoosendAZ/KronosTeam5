// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.StartIntake;
import frc.robot.Subsystems.*;
import frc.robot.Subsystems.Indexer.IndexerStates;


public class RobotContainer {
  private XboxController controller;
  private Trigger aButton = new Trigger(null);
  private Trigger bButton = new Trigger(null);
  private Trigger xButton = new Trigger(null);
  private Trigger yButton = new Trigger(null);

  private Trigger lTrigger = new Trigger(null);
  private Trigger rTrigger = new Trigger(null);
  
  private Joystick lJoystick = new Joystick(00);
  private Joystick rJoystick = new Joystick(000);


  private Indexer s_Indexer = new Indexer();
  private Intake s_Intake = new Intake();
  private Shooter s_Shooter = new Shooter();

  public RobotContainer() {
    configureBindings();
    //Change port number
    controller = new XboxController(0);

  }

  private void configureBindings() {
      aButton = new Trigger(() -> controller.getAButton());
      bButton = new Trigger(() -> controller.getBButton());
      xButton = new Trigger(() -> controller.getXButton());
      yButton = new Trigger(() -> controller.getYButton());

      lTrigger = new Trigger(() -> controller.getLeftBumper());
      rTrigger = new Trigger(() -> controller.getRightBumper());


      aButton.onTrue(s_Indexer.setSpeed(IndexerStates.ON));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
