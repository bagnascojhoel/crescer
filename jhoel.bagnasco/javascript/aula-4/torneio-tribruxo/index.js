import axios from 'axios';
  // mapa-do-maroto

// const URL = 'http://ec2-3-129-248-48.us-east-2.compute.amazonaws.com/lumos-maxima/wingardium-leviosa'
// const URL = 'http://ec2-3-129-248-48.us-east-2.compute.amazonaws.com/lumos-maxima/fofo'
// const URL = 'http://ec2-3-129-248-48.us-east-2.compute.amazonaws.com/lumos-maxima/pensar/pensar/pensar'
// const URL = 'http://ec2-3-129-248-48.us-east-2.compute.amazonaws.com/lumos-maxima/espelho-de-ojesed'
// const URL = 'http://ec2-3-129-248-48.us-east-2.compute.amazonaws.com/lumos-maxima/reliquias-da-morte'
const URL = 'http://ec2-3-129-248-48.us-east-2.compute.amazonaws.com/lumos-maxima/grifinoria'
// avada-kedavra/criciatus/imperius
const main = async () => {
  try {
    const response = await axios.get(URL, {
      headers: {
        grupo: 2,
        'the-book': 5,
        'juramento': 'Eu juro solenemente não fazer nada de bom',
      },
      params: {
        
      }
    });

    // console.log(response.request);
    // console.log(response.headers);
    // console.log(response.config);
    // console.log(response.status);
    // console.log(response.statusText);
    console.log(response.data);
    // console.log(response);


  } catch(erro) {
    console.log(erro.response)
  }
}

main()