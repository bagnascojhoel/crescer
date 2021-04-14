export const SuperArray = (...itens) => {
  const array = {
    /**
     * Propriedade para acessar os itens
     */

    itens: [...itens],
  };

  /**
   * Adicionar um novo item ao final dos items
   */
  array.push = (item) => {
    array.itens[array.itens.length] = item;
  };

  /**
   * Itera sobre cada um dos elementos do SuperArray enviando o item e o index
   * como segundo parametro
   */
  array.forEach = (callback) => {
    for (let i = 0; i < array.itens.length; i++)
      callback(itens[i]);
  };
  /**
   * Retorna um novo SuperArray com os itens mapeados
   */
  array.map = (callback) => {
    const mappedSuperArray = SuperArray();

    array.forEach((item) => {
      const mappedItem = callback(item);
      mappedSuperArray.push(mappedItem);
    })

    return mappedSuperArray;
  };

  /**
   * Retorna um SuperArray novo com os itens filtrados
   */
  array.filter = (callback) => {
    const filteredArray = SuperArray();

    array.forEach((item) => {
      const condicao = callback(item);

      if (condicao)
        filteredArray.push(item);

    })

    return filteredArray;
  };

  /**
   * Retorna o primeiro elemento do SuperArray que satisfazer o callback recebido
   * se não encontrar, deve retornar undefined
   */
  array.find = (callback) => {
  
    for (let item of array.itens) 
      if (callback(item))
        return item;

    return undefined;
  };

  /**
   * Reduz o SuperArray em um único valor
   */
  array.reduce = (callback, valorInicial) => {
    let acc = valorInicial;

    array.forEach((item) => {
      acc = callback(acc, item);
    }); 

    return acc;
  };

  return array;
};
