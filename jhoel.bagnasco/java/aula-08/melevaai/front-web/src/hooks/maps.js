export function mapMotoristaToDriver({
  cnh: { numero, categoria, dataVencimento },
  nome,
  email,
  dataNascimento,
  cpf,
  carteiraVirtual,
}) {
  return {
    cnh: {
      number: numero,
      category: categoria,
      duaDate: dataVencimento,
    },
    name: nome,
    birthDate: dataNascimento,
    cpf: cpf.numero,
    virtualWallet: carteiraVirtual,
    email,
  };
}

export function mapDriverToMotorista({
  cnh: { number, category, dueDate },
  name,
  birthDate,
  cpf,
  virtualWallet,
  email,
}) {
  return {
    cnh: { numero: number, categoria: category, dataVencimento: dueDate },
    nome: name,
    dataNascimento: birthDate,
    email,
    cpf: { numero: cpf },
    carteiraVirtual: virtualWallet,
  };
}

export function mapPassageiroToPassenger({
  carteiraVirtual,
  cpf: { numero },
  dataNascimento,
  email,
  idade,
  nome,
  notaMedia,
}) {
  return {
    virtualWallet: carteiraVirtual,
    cpf: numero,
    birthDate: dataNascimento,
    email,
    age: idade,
    name: nome,
    averageScore: notaMedia,
  };
}

export function mapPassengerToPassageiro({
  virtualWallet,
  cpf,
  birthDate,
  email,
  age,
  name,
  averageScore,
}) {
  return {
    carteiraVirtual: virtualWallet,
    cpf: { numero: cpf },
    dataNascimento: birthDate,
    email,
    idade: age,
    nome: name,
    notaMedia: averageScore,
  };
}

export function mapVeiculoToVehicle({
  proprietario,
  placa,
  marca,
  modelo,
  ano,
  cor,
  foto,
  categoria,
  qtdLugares,
  ...rest
}) {
  return {
    driver: mapMotoristaToDriver(proprietario),
    plate: placa.numero,
    brand: marca,
    model: modelo,
    year: ano,
    color: cor,
    photo: foto.url,
    category: categoria,
    qtySeats: qtdLugares,
    ...rest,
  };
}

export function mapVehicleToVeiculo({
  driver,
  plate,
  brand,
  model,
  year,
  color,
  photo,
  category,
  qtySeats,
}) {
  return {
    proprietario: mapDriverToMotorista(driver),
    placa: plate,
    marca: brand,
    modelo: model,
    ano: year,
    cor: color,
    foto: photo,
    categoria: category,
    qtdLugares: qtySeats,
  };
}
