import { render, screen } from "@testing-library/react";
import { App } from "./index";

test("renders custom navbar", () => {
	render(<App />);
	const navbar = screen.getByLabelText("navbar");
	expect(navbar).toBeInTheDocument();
});

// Verifica che vengano effettivamente renderizzate tante bootstrap cards quanti sono i libri nel file json utilizzato.

// Verifica che il componente CommentArea venga renderizzato correttamente.

// Verifica, magari con più tests, che il filtraggio dei libri tramite navbar si comporti come previsto.

// Verifica che, cliccando su un libro, il suo bordo cambi colore.

// Verifica che, cliccando su di un secondo libro dopo il primo, il bordo del primo libro ritorni normale.

// Verifica che all’avvio della pagina, senza aver ancora cliccato su nessun libro, non ci siano istanze del componente SingleComment all’interno del DOM.

// Verifica infine che, cliccando su di un libro con recensioni, esse vengano caricate correttamente all’interno del DOM.
