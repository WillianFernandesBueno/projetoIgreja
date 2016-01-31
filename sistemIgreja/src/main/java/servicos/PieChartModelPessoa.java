package servicos;

import java.util.List;

import org.primefaces.model.chart.PieChartModel;

import entidades.Pessoa;

public class PieChartModelPessoa {
	private int visitante;
	private int novoConvertido;
	private int membro;
	private int obreiro;
	private int diacono;
	private int evangelista;
	private int presbitero;
	private int pastor;
	private int missionario;
	
	public static PieChartModel inserir(List<Pessoa> pessoas) {
		for (Pessoa pessoa : pessoas) {
			
		}
		return null;
	}

	public int getVisitante() {
		return visitante;
	}

	public void setVisitante(int visitante) {
		this.visitante = visitante;
	}

	public int getNovoConvertido() {
		return novoConvertido;
	}

	public void setNovoConvertido(int novoConvertido) {
		this.novoConvertido = novoConvertido;
	}

	public int getMembro() {
		return membro;
	}

	public void setMembro(int membro) {
		this.membro = membro;
	}

	public int getObreiro() {
		return obreiro;
	}

	public void setObreiro(int obreiro) {
		this.obreiro = obreiro;
	}

	public int getDiacono() {
		return diacono;
	}

	public void setDiacono(int diacono) {
		this.diacono = diacono;
	}

	public int getEvangelista() {
		return evangelista;
	}

	public void setEvangelista(int evangelista) {
		this.evangelista = evangelista;
	}

	public int getPresbitero() {
		return presbitero;
	}

	public void setPresbitero(int presbitero) {
		this.presbitero = presbitero;
	}

	public int getPastor() {
		return pastor;
	}

	public void setPastor(int pastor) {
		this.pastor = pastor;
	}

	public int getMissionario() {
		return missionario;
	}

	public void setMissionario(int missionario) {
		this.missionario = missionario;
	}
	
	

}
