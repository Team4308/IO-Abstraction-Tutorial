package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.motor.Motor;
import frc.robot.subsystems.motor.MotorIOKraken;

public class RobotContainer {

    private final CommandXboxController controller =
            new CommandXboxController(0);

    private final Motor m_motor =
            new Motor(new MotorIOKraken());

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {

        m_motor.setDefaultCommand(
            m_motor.run(() -> {
                double joystickValue = controller.getRightX();
                double voltage = joystickValue * 12.0;

                m_motor.runVolts(voltage);
            })
        );

        controller.b().onTrue(
            m_motor.runOnce(() -> m_motor.estop())
        ); 
    }
}