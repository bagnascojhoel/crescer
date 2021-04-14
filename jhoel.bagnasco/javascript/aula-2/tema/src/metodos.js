export function filtarPorAnoERetornarNome(series, ano) {
  return series
    .filter((serie) => serie.anoEstreia >= ano)
    .map((serie) => serie.titulo);
}

// considera que receberá o nome completo
export function verificarSeAtorEstaEmSeriado(series, nomeAtor) {
  return series.some((serie) => serie.elenco.includes(nomeAtor));
}

// considera que recebera alguma string e verificará se algum item do elenco contem essa string
// export function verificarSeAtorEstaEmSeriado(series, nomeAtor) {
//   return series.some(serie => serie.elenco.some(elenco => elenco.includes(nomeAtor)));
// }

export function calcularMediaTotalDeEpisodios(series) {
  const totalEpisodios = series.reduce((acc, serie) => acc + serie.numeroEpisodios, 0);

  return totalEpisodios / series.length;
}

export function agruparTituloDasSeriesPorPropriedade(series, propriedade) {
  const grupos = series.map((serie) => serie[propriedade]);

  return grupos.reduce((objeto, grupo) => {
    const seriesDoGrupo = series.filter((serie) => serie[propriedade] === grupo);
    const titulosDoGrupo = seriesDoGrupo.map((serie) => serie.titulo);

    return { ...objeto, [grupo]: titulosDoGrupo };
  }, {});
}
