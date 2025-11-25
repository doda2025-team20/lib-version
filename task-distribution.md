Person 1 — Vagrant Infrastructure

Related A2 steps: 1.1 (Steps 1–3), networking parts of Step 2

Responsibilities
	•	Create and maintain the Vagrantfile.
	•	Define controller and worker VMs, including variable-based CPU, RAM, and worker count.
	•	Configure host-only networking with fixed IPs.
	•	Integrate Ansible provisioning into Vagrant.

⸻

Person 2 — Base System Provisioning (General Ansible)

Related A2 steps: Steps 4–12 in 1.1

Responsibilities
	•	Implement general.yaml for per-node OS configuration:
	•	SSH key distribution.
	•	Disable swap.
	•	Configure kernel modules (br_netfilter, overlay).
	•	Configure IPv4 forwarding and bridge sysctl values.
	•	Manage /etc/hosts.
	•	Add Kubernetes apt repository.
	•	Install containerd, runc, kubeadm, kubelet, kubectl.
	•	Configure containerd and start kubelet.

⸻

Person 3 — Kubernetes Controller

Related A2 steps: 1.2 (Steps 13–17)

Responsibilities
	•	Implement controller-specific provisioning in ctrl.yaml.
	•	Run and guard kubeadm init (idempotent).
	•	Set up kubectl access both on the controller and on the host.
	•	Install and configure Flannel.
	•	Install Helm on the controller (and optionally Helm diff).

⸻

Person 4 — Worker Nodes, MetalLB, and Ingress

Related A2 steps:
	•	Worker setup: 1.3 (Steps 18–19)
	•	Finalization: Steps 20–21 in 1.4

Responsibilities
	•	Implement worker join process in node.yaml.
	•	Capture and apply the Kubernetes join command.
	•	Implement finalization.yaml for cluster add-ons:
	•	Install and configure MetalLB (CRDs, IP pool, L2 ads).
	•	Install Nginx Ingress Controller via Helm.
	•	Ensure Ingress uses MetalLB-assigned IPs.

⸻

Person 5 — Dashboard, Istio, Testing, and Documentation

Related A2 steps:
	•	Dashboard: Step 22 in 1.4
	•	Istio: Step 23 in 1.4
	•	Testing: 1.5

Responsibilities
	•	Install the Kubernetes Dashboard (Helm) and required RBAC resources.
	•	Expose the Dashboard via an Ingress.
	•	Install Istio and configure gateway IPs if needed.
	•	Test the cluster using the lecture example workloads.
