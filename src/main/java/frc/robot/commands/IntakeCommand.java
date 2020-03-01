/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase
{
	protected final Intake intake;
	protected final XboxController controller;

	public IntakeCommand( Intake intake, XboxController controller )
	{
		this.intake = intake;
		this.controller = controller;

		addRequirements( intake );
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize()
	{
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute()
	{
		intake.setSpeed( ( -controller.getTriggerAxis( Hand.kLeft ) ) + controller.getTriggerAxis( Hand.kRight ) );
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end( boolean interrupted )
	{
		intake.stop();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished()
	{
		return false;
	}
}
