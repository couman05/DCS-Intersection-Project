package OETPN.Project2;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Roundabout {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Main Petri";
        pn.NetworkPort = 1085;

        DataCar p1 = new DataCar();
        p1.SetName("P1");
        pn.PlaceList.add(p1);

        DataCar p5 = new DataCar();
        p5.SetName("P5");
        pn.PlaceList.add(p5);

        DataCar p6 = new DataCar();
        p6.SetName("P6");
        pn.PlaceList.add(p6);

        DataCar p7 = new DataCar();
        p7.SetName("P7");
        pn.PlaceList.add(p7);

        DataCar p8 = new DataCar();
        p8.SetName("P8");
        pn.PlaceList.add(p8);

        DataCar p9 = new DataCar();
        p9.SetName("P9");
        pn.PlaceList.add(p9);

        DataCarQueue p2 = new DataCarQueue();
        p2.SetName("P2");
        p2.Value.Size = 3;
        pn.PlaceList.add(p2);

        DataCarQueue p3 = new DataCarQueue();
        p3.SetName("P3");
        p3.Value.Size = 3;
        pn.PlaceList.add(p3);

        DataCarQueue p4 = new DataCarQueue();
        p4.SetName("P4");
        p4.Value.Size = 3;
        pn.PlaceList.add(p4);

        // ---------- T1 --------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("P1");

        Condition T1Ct1 = new Condition(t1, "P1",TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1,"P2",TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P1",TransitionOperation.AddElement,"P2"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // ----------- T1 EXIT -------------

        PetriTransition t1exit = new PetriTransition(pn);
        t1exit.TransitionName = "T1exit";
        t1exit.InputPlaceName.add("P2");

        Condition T1exitCt1 = new Condition(t1exit, "P2",TransitionCondition.HaveCarForMe);

        GuardMapping grdT1exit = new GuardMapping();
        grdT1exit.condition = T1exitCt1;
        grdT1exit.Activations.add(new Activation(t1, "P1",TransitionOperation.PopElementWithTarget,"P6"));
        t1exit.GuardMappingList.add(grdT1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        //----------- t2 -------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("P2");

        Condition T2Ct1 = new Condition(t2, "P2", TransitionCondition.HaveCarForMe);
        Condition T2Ct2 = new Condition(t2, "P3", TransitionCondition.CanAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition= T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P2", TransitionOperation.PopElementWithTargetToQueue, "P3"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 0;
        pn.Transitions.add(t2);

        //t3

        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("P3");

        Condition t3Ct1 = new Condition(t3, "P3", TransitionCondition.HaveCarForMe);
        Condition t3Ct2 = new Condition(t3, "P4", TransitionCondition.CanAddCars);
        t3Ct1.SetNextCondition(LogicConnector.AND, t3Ct2);

        GuardMapping grdt3 = new GuardMapping();
        grdt3.condition= t3Ct1;
        grdt3.Activations.add(new Activation(t3, "P3", TransitionOperation.PopElementWithTargetToQueue, "P4"));
        t3.GuardMappingList.add(grdt3);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        //t4

        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "t4";
        t4.InputPlaceName.add("P4");

        Condition t4Ct1 = new Condition(t4, "P4", TransitionCondition.HaveCarForMe);
        Condition t4Ct4 = new Condition(t4, "P2", TransitionCondition.CanAddCars);
        t4Ct1.SetNextCondition(LogicConnector.AND, t4Ct4);

        GuardMapping grdt4 = new GuardMapping();
        grdt4.condition= t4Ct1;
        grdt4.Activations.add(new Activation(t4, "P4", TransitionOperation.PopElementWithTargetToQueue, "P2"));
        t4.GuardMappingList.add(grdt4);

        t4.Delay = 0;
        pn.Transitions.add(t4);

        //texit2

        PetriTransition texit2 = new PetriTransition(pn);
        texit2.TransitionName = "texit2";
        texit2.InputPlaceName.add("P3");

        Condition texit2Ct1 = new Condition(texit2, "P3", TransitionCondition.HaveCarForMe);

        GuardMapping grdtexit2 = new GuardMapping();
        grdtexit2.condition= texit2Ct1;
        grdtexit2.Activations.add(new Activation(texit2, "P3", TransitionOperation.PopElementWithTarget, "P7"));
        texit2.GuardMappingList.add(grdtexit2);

        texit2.Delay = 0;
        pn.Transitions.add(texit2);

        //texit3

        PetriTransition texit3 = new PetriTransition(pn);
        texit3.TransitionName = "texit3";
        texit3.InputPlaceName.add("P4");

        Condition texit3Ct1 = new Condition(texit3, "P4", TransitionCondition.HaveCarForMe);

        GuardMapping grdtexit3 = new GuardMapping();
        grdtexit3.condition= texit3Ct1;
        grdtexit3.Activations.add(new Activation(texit3, "P4", TransitionOperation.PopElementWithTarget, "P8"));
        texit3.GuardMappingList.add(grdtexit3);

        texit3.Delay = 0;
        pn.Transitions.add(texit3);

        //texit4

        PetriTransition texit4 = new PetriTransition(pn);
        texit4.TransitionName = "texit4";
        texit4.InputPlaceName.add("P2");

        Condition texit4Ct1 = new Condition(texit4, "P2", TransitionCondition.HaveCarForMe);

        GuardMapping grdtexit4 = new GuardMapping();
        grdtexit4.condition= texit4Ct1;
        grdtexit4.Activations.add(new Activation(texit4, "P2", TransitionOperation.PopElementWithTarget, "P5"));
        texit4.GuardMappingList.add(grdtexit4);

        texit4.Delay = 0;
        pn.Transitions.add(texit4);
        pn.Delay = 3000;
        //pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}

