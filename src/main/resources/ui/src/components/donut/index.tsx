import React, { useEffect, useRef, useState } from 'react';
import Chart from 'chart.js';

interface Props {}

const Donut : React.FC<Props> = (props) => {
  const canvasRef = useRef(null);
  const [chart, setChart] = useState(null);
  useEffect(() => {
    const __chart = new Chart(canvasRef.current, {
      type: 'doughnut',
      data: {
        labels: ['Red', 'Blue'],
        datasets: [{ data: [10, 20] }]
      }
    });
    setChart(__chart);
    return () => {
      chart.destroy();
    };
  }, []);

  return (
    <div>
      <canvas ref={canvasRef} width="400" height="400" />
    </div>
  )
};

export default Donut;
