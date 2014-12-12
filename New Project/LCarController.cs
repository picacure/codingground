using System.IO;
using System;

class Program
{
    static void Main()
    {
        Console.WriteLine("Hello, World!");
    }
    
    void CheckCarPos() {
        for (int i = 0, len = _cars.Count; i < len; i++) {

            if (i == _myIndexInRoom) continue;

            LCar lLcar = _cars[i].gameObject.GetComponent<LCar>();

            Vector3 relativePos = _myLCar.transform.InverseTransformPoint(lLcar.transform.position);

            //前方 4 unit处
            if (relativePos.z > 0 && relativePos.z < 4 && Mathf.Abs(relativePos.x) < 3) {

                if (_myLCar.rigidbody.velocity.magnitude > lLcar.rigidbody.velocity.magnitude)
                {
                    lLcar.rigidbody.velocity = _myLCar.rigidbody.velocity;
                }

                lLcar.SetSpeed(10, 0.5f);
                _myLCar.SetSpeed(-10, 0.5f);
            }

            //后方 4 unit处
            if (relativePos.z < 0 && relativePos.z > -4 && Mathf.Abs(relativePos.x) < 3) {

                if (_myLCar.rigidbody.velocity.magnitude < lLcar.rigidbody.velocity.magnitude)
                {
                    _myLCar.rigidbody.velocity = lLcar.rigidbody.velocity;
                }

                lLcar.SetSpeed(-10, 0.5f);
                _myLCar.SetSpeed(10, 0.5f);
            }
        }
    }
}
