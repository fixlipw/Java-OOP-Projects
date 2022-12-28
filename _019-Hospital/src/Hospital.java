
import java.util.*;

public class Hospital {
    private final TreeMap<String, IPaciente> pacientes = new TreeMap<>();
    private final TreeMap<String, IMedico> medicos = new TreeMap<>();

    public Hospital(){

    }

    public void removerPaciente(String sender){
        pacientes.remove(sender);
    }

    public void removerMedico(String sender){
        pacientes.remove(sender);
    }

    public void addPaciente(IPaciente paciente){
        pacientes.put(paciente.getId(), paciente);
    }

    public void addMedico(IMedico medico){
        medicos.put(medico.getId(), medico);
    }

    public void vincular(String nomeMedico, String nomePaciente){
        medicos.get(nomeMedico).addPaciente(pacientes.get(nomePaciente));
        pacientes.get(nomePaciente).addMedico(medicos.get(nomeMedico));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, IPaciente> entry : pacientes.entrySet()){
            StringBuilder ap = new StringBuilder("Pac: ");
            ap.append(entry.getValue()).append(String.format("%-"+(17-entry.getValue().toString().length())+"s", ""));
            ap.append("Meds: [");
            entry.getValue().getMedicos().forEach(iMedico -> ap.append(iMedico.getId()).append(", "));
            if(!entry.getValue().getMedicos().isEmpty()) ap.delete(ap.length() - 2, ap.length()).append(']').append('\n');
            else ap.append(']').append('\n');
            sb.append(ap);
        }
        for(Map.Entry<String, IMedico> entry : medicos.entrySet()){
            StringBuilder ap = new StringBuilder("Med: ");
            ap.append(entry.getValue()).append(String.format("%-"+(17-entry.getValue().toString().length())+"s", ""));
            ap.append("Pacs: [");
            entry.getValue().getPacientes().forEach(iPaciente -> ap.append(iPaciente.getId()).append(", "));
            if(!entry.getValue().getPacientes().isEmpty()) ap.delete(ap.length() - 2, ap.length()).append(']').append('\n');
            else ap.append(']').append('\n');
            sb.append(ap);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}