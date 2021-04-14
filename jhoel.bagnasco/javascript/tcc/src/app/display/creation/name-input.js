import {useQuestion} from '../../../services';
export const showNameInput = async () => {
  try {
    console.clear();
    return useQuestion(`
  World of Warcraft
==================================

  Digite o nome do seu
  personamgem

==================================
\n
`);
  } catch (error) {
    console.error(
      `Error while trying to show the name input menu: "${error}"`
    );
  }
}