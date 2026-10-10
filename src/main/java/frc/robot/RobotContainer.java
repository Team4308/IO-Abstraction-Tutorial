package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.motor.Motor;
import frc.robot.subsystems.motor.MotorIO;
import frc.robot.subsystems.motor.MotorIOKraken;
import frc.robot.subsystems.motor.MotorIOSim;

public class RobotContainer {

    private final CommandXboxController controller =
            new CommandXboxController(0);

    private final Motor m_motor;

    public RobotContainer() {
        switch (Constants.currentMode) {
            case REAL:
                m_motor = new Motor(new MotorIOKraken());
                break;
            case SIM:
                m_motor = new Motor(new MotorIOSim());
                break;
            case REPLAY:
            default:
                m_motor = new Motor(new MotorIO() {});
                break;
        }

        configureBindings();
    }

    
private boolean estopped = false;

private void configureBindings() {

    m_motor.setDefaultCommand(
        m_motor.run(() -> {
            if (estopped) {
                m_motor.runVolts(0.0);
                return;
            }

            double joystickValue =
            edu.wpi.first.math.MathUtil.applyDeadband(
                controller.getHID().getRawAxis(3), 0.08
            );
            org.littletonrobotics.junction.Logger.recordOutput(
            "Debug/RawAxis3", joystickValue
            );

        double voltage = joystickValue * 12.0;
        m_motor.runVolts(voltage);
        })
    );

    // B: Latch the emergency stop.
    controller.b().onTrue(
        m_motor.runOnce(() -> {
            estopped = true;
            m_motor.estop();
        })
    );

    // A: Reset the emergency stop.
    controller.a().onTrue(
        m_motor.runOnce(() -> {
            estopped = false;
        })
    );
}
}