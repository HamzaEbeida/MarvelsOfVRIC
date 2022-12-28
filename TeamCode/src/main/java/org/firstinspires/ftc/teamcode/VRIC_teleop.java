package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class VRIC_teleop extends LinearOpMode {
    DcMotorEx frontright;
    DcMotorEx frontleft;
    DcMotorEx backright;
    DcMotorEx backleft;
    DcMotorEx elevator;
    Servo gripper;



    public void runOpMode() throws InterruptedException {
        frontright = hardwareMap.get(DcMotorEx.class, "frontright");
        frontleft = hardwareMap.get(DcMotorEx.class, "frontleft");
        backright = hardwareMap.get(DcMotorEx.class, "backright");
        backleft = hardwareMap.get(DcMotorEx.class, "backleft");
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");
        gripper = hardwareMap.get(Servo.class, "gripper");



        waitForStart();

        while(opModeIsActive()) {
            frontright.setPower(gamepad1.right_stick_y);
            frontleft.setPower(gamepad1.left_stick_y);
            backright.setPower(-gamepad1.right_stick_y);
            backleft.setPower(-gamepad1.left_stick_y);
            elevator.setPower(gamepad2.left_stick_y);

            if(gamepad2.right_bumper) {
                gripper.setPosition(.3);
            } else if(gamepad2.left_bumper) {
                gripper.setPosition(.6);
            }

        }

    }
}
