import readline from 'readline'

export const useQuestion = (str) => new Promise(
  resolve => {
    const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout,
      terminal: false
    })
    
    rl.question(`${str}\n`, (result) => {
      rl.close()
      resolve(result)
    })
  }
)

export const useQuestionInMenu = async (str) => {
  const response = await useQuestion(str);
  return Number(response);
}