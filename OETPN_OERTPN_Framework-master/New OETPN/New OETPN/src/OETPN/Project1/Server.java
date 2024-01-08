package OETPN.Project1;
import Components.*;
import DataObjects.DataFloat;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.util.ArrayList;

public class Server {

    public static void main(String[] args) {
        PetriNet serverNet = new PetriNet();
        serverNet.PetriNetName = "Server Petri";
        serverNet.NetworkPort = 1081;

        DataFloat p0 = new DataFloat();
        p0.SetName("p0");
        p0.SetValue(1.0f);
        serverNet.PlaceList.add(p0);

        DataFloat p1 = new DataFloat();
        p1.SetName("p1");
        serverNet.PlaceList.add(p1);

        DataFloat p2 = new DataFloat();
        p2.SetName("p2");
        serverNet.PlaceList.add(p2);

        DataTransfer p3 = new DataTransfer();
        p3.SetName("p3");
        p3.Value = new TransferOperation("localhost", "1080", "p5");
        serverNet.PlaceList.add(p3);

        PetriTransition t1 = new PetriTransition(serverNet);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("p0");
        t1.InputPlaceName.add("p1");

        Condition T1Ct1 = new Condition(t1, "p0", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "p1", TransitionCondition.NotNull);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        DataFloat subConstValue = new DataFloat();
        subConstValue.SetName("subConstValue");
        subConstValue.SetValue(0.01f);
        serverNet.ConstantPlaceList.add(subConstValue);

        ArrayList<String> constValues = new ArrayList<>();
        constValues.add("p1");
        constValues.add("subConstValue");

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        // grdT1.Activations.add(new Activation(t1, constValues, TransitionOperation.Prod, "p2"));
        grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.Square, "p2"));

        t1.GuardMappingList.add(grdT1);
        serverNet.Transitions.add(t1);
        t1.Delay = 0;

        PetriTransition t2 = new PetriTransition(serverNet);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("p2");

        Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "p2", TransitionOperation.SendOverNetwork, "p3"));
        grdT2.Activations.add(new Activation(t2, "p2", TransitionOperation.Move, "p0"));

        t2.GuardMappingList.add(grdT2);
        serverNet.Transitions.add(t2);
        t2.Delay = 0;


        PetriNetWindow serverFrame = new PetriNetWindow(false);
        serverFrame.petriNet = serverNet;
        serverFrame.setVisible(true);
    }
}