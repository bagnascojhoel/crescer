import React from 'react';
import './styles.css';

const defaultProps = {
  src: undefined,
  alt: 'Thumbnail',
  large: false,
};

export const Thumbnail = ({ src, alt, large }) => {
  return (
    <div className={`thumbnail ${large && 'thumbnail--large'}`}>
      {src && <img className="thumbnail__image" src={src} alt={alt} />}
    </div>
  );
};

Thumbnail.defaultProps = defaultProps;
