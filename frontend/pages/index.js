import CardSection from '../components/card/cardSection'
import Footer from '../components/footer'
import Header from '../components/header'
import CarouselSection from '../components/carousel/carouselSection'
import axios from 'axios'
import React from 'react'


export default function Home({ products }) {

  return (
    <div className="container">

      <Header />
      <CarouselSection/>

      <div className="container">
      <CardSection products={products} />
      </div>
       <Footer />

    </div>
  )
}


export async function getStaticProps() {
  try {
    const response = await axios.get('http://localhost:8080/products');
    const products = response.data;

    return {
      props: {
        products,
      },
    };
  } catch (error) {
    console.error('Error fetching data:', error);
    return {
      props: {
        products: [],
      },
    };
  }
}


// import axios from 'axios';
// import React from 'react';
// import CardSection from '../components/card/cardSection';

// export default function Home({ products }) {
//   // console.log(products);
//   return (
//     <div className="container">
//       <CardSection products={products} />
//     </div>
//   );
// }