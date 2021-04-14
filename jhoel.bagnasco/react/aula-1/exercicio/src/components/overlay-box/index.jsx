import React from 'react';
import './styles.css';

export function OverlayBox({
  overlayColor,
  backgroundImage,
  width,
  height,
  children,
}) {
  return (
    <div
      className="overlay-box"
      style={{
        backgroundImage: `url(${backgroundImage})`,
        width: width ?? 'auto',
        height: height ?? 'auto',
      }}
    >
      <div
        className="overlay-box__overlay"
        style={{ backgroundColor: overlayColor }}
      ></div>

      <div className="overlay-box__content">{children}</div>
    </div>
  );
}
